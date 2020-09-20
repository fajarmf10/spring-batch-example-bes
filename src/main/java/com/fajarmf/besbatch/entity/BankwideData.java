package com.fajarmf.besbatch.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "BANKWIDE_DATA")
public class BankwideData {
    private static final long serialVersionUID = 1L;

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    private Date businessDate;

    private Date tanggalTrx;

    private String jamTransaksi;

    private String cutOff;

    private String noGl;

    private String tc;

    private String transactionCode;

    private String noRekening;

    private String noKartu;

    private String noReff;

    private String termId;

    private BigDecimal amount;

    private String statusTransaksi;

    private String bank;

    private String transactionType;

    private String mitra;

    private String sourceData;

    private BigDecimal aging;

    private String remark;

    private String ersId;

    private String rrn;

    private String merchantName;
}
