package sl.springboot.test.interview;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class TimeSeriesStore {

    private Map<LocalDate, List<StoreObj>> map = new HashMap<LocalDate, List<StoreObj>>();

    public TimeSeriesStore() {

    }

    private static class StoreObj{
        private LocalDate asof;
        private Double value;
        private String asset;
        private LocalDateTime createdTime;

        public LocalDate getAsof() {
            return asof;
        }

        public void setAsof(LocalDate asof) {
            this.asof = asof;
        }

        public Double getValue() {
            return value;
        }

        public void setValue(Double value) {
            this.value = value;
        }

        public String getAsset() {
            return asset;
        }

        public void setAsset(String asset) {
            this.asset = asset;
        }

        public LocalDateTime getCreatedTime() {
            return createdTime;
        }

        public void setCreatedTime(LocalDateTime createdTime) {
            this.createdTime = createdTime;
        }
    }

    //Add the rate in memory
    public void addData(LocalDate asof, String asset, double value, LocalDateTime created_time){
        StoreObj o = new StoreObj();
        o.setAsof(asof);
        o.setAsset(asset);
        o.setValue(value);
        o.setCreatedTime(created_time);


        List<StoreObj> storeObjs = map.get(asof);
        if(storeObjs != null){
            storeObjs.add(o);
        }else{
            List<StoreObj> objs = new ArrayList<>();
            objs.add(o);
            map.put(asof,objs);
        }
    }

    //Query the latest rate on date 'asof' for each asset when 'created' is not present
    //Otherwise, if 'created' present, return the latest rate which is less or equals than the 'created' timestamp
    public double getData(LocalDate asof, String asset, Optional<LocalDateTime> created) {

        double ret = 0;
        List<StoreObj> storeObjs = map.get(asof);
        if(null!=storeObjs){
            Optional<StoreObj> max = storeObjs.stream().
                    filter(as -> as.equals(asset)).max(Comparator.comparing(StoreObj::getValue));
            ret = max.get().getValue();
        }
        return ret;
    }

    public static void main(String[] argvs) {
        TimeSeriesStore timeSeries = new TimeSeriesStore();

        LocalDate dt1 = LocalDate.of(2021, 01, 01),
                dt2 = LocalDate.of(2021, 01, 02);

        timeSeries.addData(dt1, "USDSGD", 1.03, LocalDateTime.of(2021, 01, 01, 15, 20));
        timeSeries.addData(dt1, "USDSGD", 1.10, LocalDateTime.of(2021, 01, 01, 11, 10));

        timeSeries.addData(dt1, "USDCNY", 1.01, LocalDateTime.of(2021, 01, 01, 11, 30));
        timeSeries.addData(dt1, "USDCNY", 1.04, LocalDateTime.of(2021, 01, 01, 9, 5));

        timeSeries.addData(dt2, "USDSGD", 1.02, LocalDateTime.of(2021, 01, 02, 10, 10));
        timeSeries.addData(dt2, "USDCNY", 6.11, LocalDateTime.of(2021, 01, 02, 19, 0));
        timeSeries.addData(dt2, "USDCNY", 6.13, LocalDateTime.of(2021, 01, 02, 11, 30));

        //Case 1
        //"USDSGD" -> 1.03
        double d1LastRatesUsdSgd = timeSeries.getData(dt1, "USDSGD", Optional.empty());

        //"USDCNY" -> 1.01
        double d1LastRatesUsdCny = timeSeries.getData(dt1, "USDCNY", Optional.empty());

        //Case 2
        LocalDateTime d1Created = LocalDateTime.of(2021, 01, 01, 11, 30);

        // "USDSGD" -> 1.10
        double d1CutOffRates = timeSeries.getData(dt1, "USDSGD", Optional.of(d1Created));

        System.out.println(d1CutOffRates);
    }



}
