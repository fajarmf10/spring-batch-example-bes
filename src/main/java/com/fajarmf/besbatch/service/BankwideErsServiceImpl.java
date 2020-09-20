package com.fajarmf.besbatch.service;

import com.fajarmf.besbatch.entity.BankwideData;
import org.springframework.batch.item.excel.support.rowset.RowSet;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BankwideErsServiceImpl implements BankwideErsService {

    private final SimpleDateFormat myDateFormatter = new SimpleDateFormat("dd-MMM-yy");

    @Override
    public BankwideData mapRow(RowSet rowSet) throws Exception {
        String businessDateString = rowSet.getColumnValue(0);
        String tanggalTransaksiString = rowSet.getColumnValue(1);
        Date businessDate = myDateFormatter.parse(businessDateString);
        Date tanggalTransaksi = myDateFormatter.parse(tanggalTransaksiString);
        BankwideData bankwideData = new BankwideData();
        bankwideData.setBusinessDate(businessDate);
        bankwideData.setTanggalTrx(tanggalTransaksi);
        bankwideData.setJamTransaksi(rowSet.getColumnValue(2));
        bankwideData.setCutOff(rowSet.getColumnValue(3));
        bankwideData.setNoGl(rowSet.getColumnValue(4));
        bankwideData.setTc(rowSet.getColumnValue(5));
        return bankwideData;
    }
}
