public class main {
    public static void main(String[] args) {
        myList<Integer> list = new myList<>();
        list.add(10);
        list.add(333);
        list.add(28);
        list.add(42);
        list.add(37);

        list.getCapacity();
        list.get(1);
        list.remove(6);
        list.set(2,85);
        list.printList();
        System.out.println(list.toString());
        System.out.println("Indeks : " + list.indexOf(44));
        myList<Integer> altListem = list.subList(0, 3);
        System.out.println(altListem.toString());
        list.contains(28);
        System.out.println(list.contains(10));

       /* System.out.println("Dizinin Kapasitesi : " + list.getCapacity());
        System.out.println("Dizideki Eleman Sayısı : " + list.size());
        System.out.println("1. indisteki değer : " + list.get(1));*/
    }
}
