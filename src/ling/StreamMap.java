package ling;

import java.util.*;

 class StreamMap<TKey,TValue> implements SessionMap<TKey,TValue>{

         private Map<TKey, TValue> mMap;

         public StreamMap(Map<TKey, TValue> map) {
                 this.mMap = map;//pair
         }

         @Override
        public SessionMap<TKey, TValue> whereKey(Predicate<TKey> key) {
             Map<TKey, TValue>map=new HashMap<>();
             for (TKey tkey : mMap.keySet()) {
                 if(key.apply(tkey)){
                     map.put(tkey,mMap.get(tkey));
                 }
             }
             return new StreamMap<>(map);
        }


        @Override
        public SessionMap<TKey, TValue> whereValue(Predicate<TValue> value) {
            Map<TKey, TValue>map=new HashMap<>();
            for (TKey tkey : mMap.keySet()) {
                TValue val=mMap.get(tkey);
                if(value.apply(val)){
                    map.put(tkey,val);
                }
            }
            return new StreamMap<>(map);
        }

     @Override
     public ling.Pair<TKey, TValue> firstOrDefault(Predicate<TValue> valuePredicate) {
         for (TKey tkey : mMap.keySet()) {
             if(valuePredicate.apply(mMap.get(tkey))){
                 return new ling.Pair<>(tkey,mMap.get(tkey));
             }
         }
         return null;
     }

     @Override
     public Number max(Function<TValue, Number> func) {
         Number acum=null;
         for (TValue d : mMap.values()) {
             acum=Utils.maxNumbers(acum,func.Foo(d));
         }
         return acum;
     }

     @Override
     public Number min(Function<TValue, Number> func) {
         Number acum=null;
         for (TValue d : mMap.values()) {
             acum=Utils.minNumbers(acum,func.Foo(d));
         }
         return acum;
     }

     @Override
     public Session<TValue> maxCollection(Function<TValue, Number> func) {

         Collection<TValue> list=new ArrayList<>();
         Double d=null;
         for (TValue value : mMap.values()) {
             double  f=func.Foo(value).doubleValue();
             if(d==null){
                 d=f;
                 list.add(value);
                 continue;
             }
             if(d==f){
                 list.add(value);
                 continue;
             }
             if(f<d)continue;
             if(f>d){
                 d=f;
                 list.clear();
                 list.add(value);
             }
         }

         return new Stream<>(list);
     }

     @Override
     public Session<TValue> minCollection(Function<TValue, Number> func) {
         Collection<TValue> list=new ArrayList<>();
         Double d=null;
         for (TValue value : mMap.values()) {
             double  f=func.Foo(value).doubleValue();
             if(d==null){
                 d=f;
                 list.add(value);
                 continue;
             }
             if(d==f){
                 list.add(value);
                 continue;
             }
             if(f>d)continue;
             if(f<d){
                 d=f;
                 list.clear();
                 list.add(value);
             }
         }

         return new Stream<>(list);
     }

     @Override
     public Number sum(Function<TValue, Number> func) {
         Number acum=null;
         for (TValue d : mMap.values()) {
             Number sd=func.Foo(d);
             acum=Utils.addNumbers(acum,sd);
         }
         return acum;
     }

     @Override
     public List<ling.Pair<TKey, TValue>> toList() {
         List<ling.Pair<TKey, TValue>> res=new ArrayList<>();
         for (TKey tkey : mMap.keySet()) {
             TValue d=mMap.get(tkey);
             res.add(new ling.Pair<>(tkey,d));
         }
         return  res;
     }

     @Override
     public boolean any(Predicate<TValue> predicate) {
         for (TValue d : mMap.values()) {
             if(predicate.apply(d)){
                 return true;
             }
         }
         return false;
     }

     @Override
     public boolean anyAll(Predicate<TValue> predicate) {
         boolean res=true;
         for (TValue d :mMap.values()) {
             if(!predicate.apply(d)){
                 res=false;
                 break;
             }
         }
         return res;
     }

     @Override
     public Map<TKey, TValue> toMap() {
         return mMap;
     }

     @Override
     public <TCast> SessionMap<TKey, TCast> cast(Function<TValue, TCast> func) {
         Map<TKey,TCast> map=new HashMap<>();
         for (TKey tKey : mMap.keySet()) {
             TValue tValue=  mMap.get(tKey);
             TCast tCast=func.Foo(tValue);
             map.put(tKey,tCast);
         }
         return new StreamMap<>(map);
     }

     @Override
     public SessionMap<TKey, TValue> forEach(ActionMap<TKey, TValue> actionMap) {
         for (TKey tKey : mMap.keySet()) {
             actionMap.Action(tKey,mMap.get(tKey));
         }
         return this;
     }


     @Override
        public int size() {
              return   mMap.size();
        }

        @Override
        public boolean isEmpty() {
                return mMap.isEmpty();
        }

        @Override
        public boolean containsKey(Object key) {
                return mMap.containsKey(key);
        }

        @Override
        public boolean containsValue(Object value) {
                return mMap.containsValue(value);
        }

        @Override
        public TValue get(Object key) {
                return mMap.get(key);
        }

        @Override
         public TValue put(TKey key, TValue value) {
                 return mMap.put(key,value);
         }

        @Override
        public TValue remove(Object key) {
                return mMap.remove(key);
        }

        @Override
        public void putAll(Map<? extends TKey, ? extends TValue> m) {
            mMap.putAll(m);
        }

        @Override
        public void clear() {
             mMap.clear();
        }

        @Override
        public Set<TKey> keySet() {
                return mMap.keySet();
        }

        @Override
        public Collection<TValue> values() {
                return mMap.values();
        }

        @Override
        public Set<Entry<TKey, TValue>> entrySet() {
                return mMap.entrySet();
        }
}
