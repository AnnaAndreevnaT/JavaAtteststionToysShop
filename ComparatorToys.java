
    import java.util.Comparator;

public class ComparatorToys implements Comparator<Toy> {
    public int compare(Toy s1, Toy s2) {
        //some code
        if (s1.getFrequencyToy() < s2.getFrequencyToy()) return -1;
        if (s1.getFrequencyToy() > s2.getFrequencyToy()) return 1;
        return 0;
    }
}
    

