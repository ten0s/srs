-module(foldl_list).
-export([main/1]).
-include_lib("eunit/include/eunit.hrl").

-spec foldl(fun ((T, Acc) -> Acc), Acc, [T]) -> Acc.
%% SOLUTION_BEGIN
foldl(_Fun2, Acc0, []) ->
    Acc0;
foldl(Fun2, Acc, [X | Xs]) ->
    foldl(Fun2, Fun2(X, Acc), Xs).
%% SOLUTION_END

main(_) ->
    case eunit:test(?MODULE) of
    ok -> halt(0);
    _  -> halt(1)
    end.

append_test() ->
    L = [1,2,3,4,5],
    ?assertEqual(length(L), foldl(fun (_, Acc) -> 1 + Acc end, 0, L)),
    ?assertEqual(lists:reverse(L), foldl(fun (X, Acc) -> [X | Acc] end, [], L)),
    ?assertEqual(lists:sum(L), foldl(fun erlang:'+'/2, 0, L)).
