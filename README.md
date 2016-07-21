# android_linq
very simple
```java
        class User{
            private final String name;
            private final String address;
            private final int ago;

            public User(String name, String address, int ago){

                this.name = name;
                this.address = address;
                this.ago = ago;
            }
        }

      List<User> listbase= Arrays.asList(new User("ivan","omsk",20),new User("denis","london",12),new User("sioma","moskau",100));

       boolean w= Linq.toStream(listbase).any(new Predicate<User>() {
            @Override
            public boolean apply(User t) {
               return t.ago<20;
            }
        });
        List<User> listUser=Linq.toStream(listbase).where(a->a.ago==20||a.ago==12).toList();
        

        Map<Integer,User> mapUser=Linq.toStream(listbase).toMapP(t -> new Pair<Integer, User>(t.ago,t));

        List<Pair<Integer,User>> sde=  Linq.toStream(mapUser).whereKey(s->s==20).toList();
```
