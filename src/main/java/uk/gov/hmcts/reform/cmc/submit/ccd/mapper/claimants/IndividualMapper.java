package uk.gov.hmcts.reform.cmc.submit.ccd.mapper.claimants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import uk.gov.hmcts.cmc.ccd.domain.CcdClaimant;
import uk.gov.hmcts.cmc.ccd.domain.CcdCollectionElement;
import uk.gov.hmcts.reform.cmc.submit.ccd.mapper.common.AddressMapper;
import uk.gov.hmcts.reform.cmc.submit.domain.models.claimants.Individual;

@Component
public class IndividualMapper {

    private final AddressMapper addressMapper;
    private final RepresentativeMapper representativeMapper;

    @Autowired
    public IndividualMapper(AddressMapper addressMapper, RepresentativeMapper representativeMapper) {
        this.addressMapper = addressMapper;
        this.representativeMapper = representativeMapper;
    }

    public void to(Individual individual, CcdClaimant.CcdClaimantBuilder builder) {

        builder.partyPhone(individual.getMobilePhone());

        builder.partyDateOfBirth(individual.getDateOfBirth());
        builder.partyName(individual.getName());
        builder.partyAddress(addressMapper.to(individual.getAddress()));
        builder.partyCorrespondenceAddress(addressMapper.to(individual.getCorrespondenceAddress()));


        representativeMapper.to(individual.getRepresentative(), builder);


    }

    public Individual from(CcdCollectionElement<CcdClaimant> claimant) {
        CcdClaimant value = claimant.getValue();

        Individual individual = new Individual();
        individual.setId(claimant.getId());
        individual.setName(value.getPartyName());
        individual.setAddress(addressMapper.from(value.getPartyAddress()));
        individual.setCorrespondenceAddress(addressMapper.from(value.getPartyCorrespondenceAddress()));
        individual.setMobilePhone(value.getPartyPhone());
        individual.setRepresentative(representativeMapper.from(value));
        individual.setDateOfBirth(value.getPartyDateOfBirth());

        return individual;
    }
}
