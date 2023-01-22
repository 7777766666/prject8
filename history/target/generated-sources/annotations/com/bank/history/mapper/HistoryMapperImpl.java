package com.bank.history.mapper;

import com.bank.history.model.HistoryDto;
import com.bank.history.model.HistoryEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-21T23:43:41+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
@Component
public class HistoryMapperImpl implements HistoryMapper {

    @Override
    public HistoryEntity toEntity(HistoryDto history) {
        if ( history == null ) {
            return null;
        }

        HistoryEntity historyEntity = new HistoryEntity();

        historyEntity.setId( history.getId() );
        historyEntity.setTransferAuditId( history.getTransferAuditId() );
        historyEntity.setProfileAuditId( history.getProfileAuditId() );
        historyEntity.setAccountAuditId( history.getAccountAuditId() );
        historyEntity.setAntiFraudAuditId( history.getAntiFraudAuditId() );
        historyEntity.setPublicBankInfoAuditId( history.getPublicBankInfoAuditId() );
        historyEntity.setAuthorizationAuditId( history.getAuthorizationAuditId() );

        return historyEntity;
    }

    @Override
    public HistoryDto toDto(HistoryEntity historyEntity) {
        if ( historyEntity == null ) {
            return null;
        }

        HistoryDto historyDto = new HistoryDto();

        historyDto.setId( historyEntity.getId() );
        historyDto.setTransferAuditId( historyEntity.getTransferAuditId() );
        historyDto.setProfileAuditId( historyEntity.getProfileAuditId() );
        historyDto.setAccountAuditId( historyEntity.getAccountAuditId() );
        historyDto.setAntiFraudAuditId( historyEntity.getAntiFraudAuditId() );
        historyDto.setPublicBankInfoAuditId( historyEntity.getPublicBankInfoAuditId() );
        historyDto.setAuthorizationAuditId( historyEntity.getAuthorizationAuditId() );

        return historyDto;
    }

    @Override
    public HistoryEntity convertWithoutId(HistoryDto historyDto, HistoryEntity historyEntity) {
        if ( historyDto == null ) {
            return historyEntity;
        }

        historyEntity.setTransferAuditId( historyDto.getTransferAuditId() );
        historyEntity.setProfileAuditId( historyDto.getProfileAuditId() );
        historyEntity.setAccountAuditId( historyDto.getAccountAuditId() );
        historyEntity.setAntiFraudAuditId( historyDto.getAntiFraudAuditId() );
        historyEntity.setPublicBankInfoAuditId( historyDto.getPublicBankInfoAuditId() );
        historyEntity.setAuthorizationAuditId( historyDto.getAuthorizationAuditId() );

        return historyEntity;
    }
}
