-module(tower_of_hanoi).
%%+BEGIN_FOLD Tests {
-export([main/1]).
-include_lib("eunit/include/eunit.hrl").
%%+END_FOLD }

-type label() :: any().
-type item()  :: any().
-type from()  :: label().
-type to()    :: label().
-type spare() :: label().
-type board() :: #{from()  := [item()],
                   to()    := [item()],
                   spare() := [item()]}.

-spec move(from(), to(), spare(), board()) -> board().
%%+BEGIN_SOLUTION
move(From, To, Spare, Board) ->
    N = length(maps:get(From, Board)),
    move_n(N, From, To, Spare, Board).

move_n(0, _From, _To, _Spare, Board) ->
    Board;
move_n(N, From, To, Spare, Board) ->
    Board1 = move_n(N-1, From, Spare, To, Board),
    Board2 = move_1(From, To, Board1),
    move_n(N-1, Spare, To, From, Board2).

move_1(From, To, Board) ->
    [Top | FromL] = maps:get(From, Board),
    ToL           = maps:get(To, Board),
    Board#{From => FromL, To => [Top | ToL]}.
%%+END_SOLUTION

%%+BEGIN_FOLD Tests {
main(_) ->
    case eunit:test(?MODULE) of
    ok -> halt(0);
    _  -> halt(1)
    end.

move_test() ->
    ?assertEqual(#{a=>[], b=>[], c=>[]},
                 move(a, b, c, #{a=>[], b=>[], c=>[]})),
    ?assertEqual(#{a=>[], b=>[1,2,3], c=>[]},
                 move(a, b, c, #{a=>[1,2,3], b=>[], c=>[]})),
    ?assertEqual(#{a=>[1,2,3], b=>[], c=>[]},
                 move(c, a, b, #{a=>[], b=>[], c=>[1,2,3]})),
    ?assertEqual(#{a=>[], b=>[1,2,3,4,5,6,7,8,9], c=>[]},
                 move(a, b, c, #{a=>[1,2,3,4,5,6,7,8,9], b=>[], c=>[]})).

%%+END_FOLD }
