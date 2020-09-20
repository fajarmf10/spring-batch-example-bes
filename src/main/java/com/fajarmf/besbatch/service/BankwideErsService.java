package com.fajarmf.besbatch.service;

import com.fajarmf.besbatch.entity.BankwideData;
import org.springframework.batch.item.excel.RowMapper;

public interface BankwideErsService extends RowMapper<BankwideData> {
}
