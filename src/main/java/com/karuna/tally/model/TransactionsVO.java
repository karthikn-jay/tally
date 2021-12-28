package com.karuna.tally.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table (name = "TALLY_TRANSACTIONS")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter @Builder
public class TransactionsVO implements Serializable {

    @Id
    private Integer id;

    private String name;

    private String itemSize;

    private Integer itemQty;

    private Integer itemVal;

}
