
import ling.Function;
import ling.Linq;
import ling.Pair;


import java.io.Serializable;
import java.util.*;


public class Main {


    public static void main(String[] args) {

        Set<Integer> sd=new HashSet<Integer>(Arrays.asList(1,2,3,4,5,67,56));
        Collection<Integer> ssss=Linq.toStream(sd).select(a->a).where(s->s>50).toCollection();
        Map<Integer,Integer> ss=Linq.toStream(sd).toMapP(new Function<Integer, Pair<Integer, Integer>>() {
            @Override
            public Pair<Integer, Integer> Foo(Integer t) {
                return new Pair<>(t, t);
            }
        });
        List<LawInfo> list=new ArrayList<>();
        init(list);
        Map<LawInfoType,Collection<LawInfo>> res=Linq.toStream(list).where(a->a.lawInfoText.equals("Футбол")).groupBy(t -> t.textType);
        res.forEach(((lawInfoType, lawInfos) -> { res.put(lawInfoType,Linq.toStream(lawInfos).minCollection(t -> t.minDate).toList()); }));
        Map<LawInfoType , List<Game>> map=Linq.toStream(res).cast(t -> Linq.toStream(t).cast(t1 -> t1.game).toList());
    }













    static void init( List<LawInfo> list){
        {
            LawInfo info=new LawInfo();
            info.id=1L;
            info.minDate=1;
            info.state=State.ready;
            info.textType=LawInfoType.small;
            info.lawInfoText="Футбол";
            info.game=new Game(12L,"Футбол");
            list.add(info);
        }
        {
            LawInfo info=new LawInfo();
            info.id=1L;
            info.minDate=2;
            info.state=State.ready;
            info.textType=LawInfoType.small;
            info.lawInfoText="Футбол";
            info.game=new Game(12L,"Футбол");
            list.add(info);
        }
        {
            LawInfo info=new LawInfo();
             info.id=1L;
            info.minDate=1;
            info.state=State.ready;
            info.textType=LawInfoType.small;
            info.lawInfoText="Футбол";
            info.game=new Game(12L,"Футбол");
            list.add(info);
        }
    }
}


 class LawInfo implements Serializable {
    public Long id;
    public int minDate;
    public State state;
    public LawInfoType textType;
    public String lawInfoText;
    public Game game;
}

 enum LawInfoType {
    big, middle , small;
}



 enum State {
    draft, ready, cancel;
}


 class Game implements Serializable {
     public Game(Long id,String gameName){
         this.gameName=gameName;
         this.id=id;
     }
    public Long id;
    public String gameName;
}