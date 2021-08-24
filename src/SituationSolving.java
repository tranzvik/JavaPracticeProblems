import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.sun.tools.internal.xjc.reader.Ring.add;

public class SituationSolving
{
    /**
     * Arrays.asList does not support add method when called in some other class
     */
    private List<String> testList;
            //Arrays.asList("VanDjk","VanPersie","MezutOzil","CarlosPuyol");

    SituationSolving() {
        testList = new ArrayList<>();
        testList = Stream.of("VanDjk","VanPersie","MezutOzil","CarlosPuyol").collect(Collectors.toList());
        Collections.unmodifiableList(testList);
    }
    public List<String> getTestList() {
      // return new ArrayList<>(testList);
        return testList;
    }

    public void setTestList(List<String> testList) {
        this.testList = testList;
    }
}
