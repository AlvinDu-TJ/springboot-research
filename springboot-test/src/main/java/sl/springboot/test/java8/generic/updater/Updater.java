package sl.springboot.test.java8.generic.updater;

import sl.springboot.test.java8.generic.bean.Master;
import sl.springboot.test.java8.generic.bean.MasterWrapper;

import java.util.List;

public interface Updater {
    <T extends Master>void execute(List<MasterWrapper<T>> wrappers);
}
