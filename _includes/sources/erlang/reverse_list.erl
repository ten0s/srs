-module(reverse_list).
%%+BEGIN_FOLD Tests {
-export([main/1]).
-include_lib("eunit/include/eunit.hrl").
%%+END_FOLD }

-spec reverse([T]) -> [T].
%%+BEGIN_SOLUTION
reverse(Xs) ->
    reverse(Xs, []).

reverse([X | Xs], Acc) ->
    reverse(Xs, [X | Acc]);
reverse([], Acc) ->
    Acc.
%%+END_SOLUTION

%%+BEGIN_FOLD Tests {
main(_) ->
    case eunit:test(?MODULE) of
    ok -> halt(0);
    _  -> halt(1)
    end.

reverse_test() ->
    ?assertEqual([], reverse([])),
    ?assertEqual([3,2,1], reverse([1,2,3])).
%%+END_FOLD }
