package com.bank.history.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

/**
 * Entity для таблицы history.
 */
@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "history", schema = "history")
public class HistoryEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "transfer_audit_id")
    private Long transferAuditId;

    @Column(name = "profile_audit_id")
    private Long profileAuditId;

    @Column(name = "account_audit_id")
    private Long accountAuditId;

    @Column(name = "anti_fraud_audit_id")
    private Long antiFraudAuditId;

    @Column(name = "public_bank_info_audit_id")
    private Long publicBankInfoAuditId;

    @Column(name = "authorization_audit_id")
    private Long authorizationAuditId;

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof HistoryEntity that)) return false;
//        return getId().equals(that.getId()) && Objects.equals(getTransferAuditId(),
//                that.getTransferAuditId()) && Objects.equals(getProfileAuditId(),
//                that.getProfileAuditId()) && Objects.equals(getAccountAuditId(),
//                that.getAccountAuditId()) && Objects.equals(getAntiFraudAuditId(),
//                that.getAntiFraudAuditId()) && Objects.equals(getPublicBankInfoAuditId(),
//                that.getPublicBankInfoAuditId()) && Objects.equals(getAuthorizationAuditId(),
//                that.getAuthorizationAuditId());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getId(), getTransferAuditId(), getProfileAuditId(), getAccountAuditId(),
//                getAntiFraudAuditId(), getPublicBankInfoAuditId(), getAuthorizationAuditId());
//    }
}
