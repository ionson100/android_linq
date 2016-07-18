package ling;

import java.util.Collection;
import java.util.List;
import java.util.Map;


public interface Session<D> extends Collection<D> {
    /**
     * Возвращает последовательность элементов, где
     * какждый элемент удовлеторяет предикату
     * @param iCompare
     * @return
     */
    Session<D> where(Predicate<D> iCompare);


    /** Вытаскивает последовательность из базовой последовательности
     * @param start  началао  вытаскивания из базовой
     * @param count количество вытащенных элементов
     *
     * @return
     */
    Session<D> limit(int start,int count);

    /**
     * выбирает определенное количество элементов
     * @param count int
     * @return Session
     */
    Session<D> limit(int count);

    /**
     *  преобразует  коллекцию типов элементов, в коллекцию другого типа
     * @param function
     * @param <TRes>
     * @return
     */
    <TRes> Session<TRes> select(Function<D, TRes> function);

    /**
     * сортирует солекцию по назначеному полю
     * @param function
     * @param <TRes>
     * @return
     */
    <TRes>Session<D> orderBy(final Function<D, TRes> function);

    /**
     * досортировывает сортировоную коллекцию
     * @param function
     * @param <TRes>
     * @return
     */
    <TRes> Session<D> thenBy(final Function<D, TRes> function);

    /**
     * возврашает новый объект базовой коллекции
     * @return
     */
    Collection<D> toCollection();

    /**
     * удаляет из коллекции елементы заданные по условию
     * @param iCompare
     * @return
     */
    Session<D> removeIf(Predicate<D> iCompare);


    /**
     * преобразует базовую коллекцию в лист
     * @return
     */
    List<D> toList();

    /**
     * возвращает первый элемент по заданному условию
     * @param dPredicate
     * @return
     */
    D firstOrDefault(Predicate<D> dPredicate);

    /**
     * определяет есть ли в коллекции элемент по заданному условию
     * @param dPredicate
     * @return
     */
    boolean any(Predicate<D> dPredicate);

    /**
     * определяет удовлетворяют ли все элементы коллекции заданному условию
     * @param dPredicate
     * @return
     */
    boolean anyAll(Predicate<D> dPredicate);
    /**
     * преобразует коллекцию в словарь
     * @return
     */
    <TValue, Tkey> Map<Tkey, TValue> toMap(Function<D, Tkey> key, Function<D, TValue> value);
    /**
     * преобразует коллекцию в словарь
     * @return
     */
    <TValue, Tkey> Map<Tkey, TValue> toMapP(Function<D, Pair<Tkey, TValue>> pairFunction);

    /**
     *  преобразует  коллекцию типов элементов, в коллекцию другого типа
     *  по аналогии select
     * @param func
     * @param <F>
     * @return
     */
    <F> Session<F> cast(Function<D,F> func);




    /**
     * вычисляет max значение по заданному полю
     * @param func
     * @return
     */
    <Tkey> Map<Tkey,Collection<D>> groupBy(Function<D, Tkey> func);
    Number max(Function<D,Number> func);
    /**
     * вычисляет min значение по заданному полю
     * @param func
     * @return
     */
    Number min(Function<D,Number> func);
    /**
     * вычисляет  сумму эелементов по заданному полю
     * @param func
     * @return
     */
    Number sum(Function<D,Number> func);

    /**
     * доступ по индексу
     * @param index
     * @return
     */
    D get(int index);

    /**
     * сравнивает две колллекции по определенному предикату
     * @param collection
     * @param iCompare
     * @return
     */
    boolean compare(Collection<D> collection,PredicateCopmare<D> iCompare);

    /**
     * Одностороннее перемещение по элементам коллекции
     * @param dAction
     * @return
     */
    Session<D> forEach(Action<D> dAction);
    /**
     * группирует элементы коллекции по заданному условию
     * @param key
     * @param <TKey>
     * @return
     */
    <TKey> Map<TKey,Collection<D>> croupBy(Function<D, TKey> key);

    int Count(Predicate<D> dPredicate);

    /**
     * Возращает минимальные элементы по заданному полю, поле должно быть Number
     * @param func
     * @return
     */
    Session<D>  minCollection(Function<D,Number> func);

    /**
     * Возращает максимальные элементы по заданному полю, поле должно быть Number
     * @param func
     * @return
     */
    Session<D>  maxCollection(Function<D,Number> func);








}
