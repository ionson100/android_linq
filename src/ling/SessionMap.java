package ling;


import java.util.List;
import java.util.Map;


public interface SessionMap<Tkey,TValue> extends Map<Tkey,TValue>{

        SessionMap<Tkey,TValue> whereKey(Predicate<Tkey> key);
        SessionMap<Tkey,TValue> whereValue(Predicate<TValue> value);
        ling.Pair<Tkey,TValue> firstOrDefault(Predicate<TValue> valuePredicate);
        Number max(Function<TValue,Number> func);
        Number min(Function<TValue,Number> func);
        Session<TValue> maxCollection(Function<TValue,Number> func);
        Session<TValue> minCollection(Function<TValue,Number> func);
        Number sum(Function<TValue,Number> func);
        List<ling.Pair<Tkey,TValue>> toList();
        boolean any(Predicate<TValue> predicate);
        boolean anyAll(Predicate<TValue> predicate);
        Map<Tkey,TValue> toMap();
      <TCast>  SessionMap<Tkey,TCast> cast(Function<TValue,TCast> func);
        SessionMap<Tkey,TValue> forEach(ActionMap<Tkey,TValue> actionMap);



}

