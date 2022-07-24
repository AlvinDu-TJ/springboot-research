package sl.springboot.test.java8.generic.updater;

import sl.springboot.test.java8.generic.bean.Master;
import sl.springboot.test.java8.generic.bean.MasterWrapper;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MasterUpdater<R extends Master> implements Updater {

    private R obj;

    static Comparator<MasterWrapper> comparing = Comparator.comparing(MasterWrapper::getCreateDate);

    protected <W extends Master> void update(List<W> list) {
            list.forEach(l->{
                System.out.println(l.equals(obj));
            });
    }

    @Override
    public <T extends Master> void execute(List<MasterWrapper<T>> masterWrappers) {
        List<T> collect = masterWrappers.stream().map(MasterWrapper::getObj).collect(Collectors.toList());

        Comparator<MasterWrapper> comparing = Comparator.comparing(MasterWrapper::getCreateDate);
        masterWrappers.stream().sorted();

        this.update(collect);
    }

    protected static <T extends Master> void staticExecute(List<MasterWrapper<T>> masterWrappers){

        List<MasterWrapper<T>> collect = masterWrappers.stream().sorted(comparing).collect(Collectors.toList());

    }
}
