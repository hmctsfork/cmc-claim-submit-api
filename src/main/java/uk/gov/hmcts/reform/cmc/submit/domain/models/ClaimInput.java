package uk.gov.hmcts.reform.cmc.submit.domain.models;

import lombok.Data;

import uk.gov.hmcts.reform.cmc.submit.domain.models.amount.Amount;
import uk.gov.hmcts.reform.cmc.submit.domain.models.claimants.Party;
import uk.gov.hmcts.reform.cmc.submit.domain.models.defendants.TheirDetails;
import uk.gov.hmcts.reform.cmc.submit.domain.models.evidence.Evidence;
import uk.gov.hmcts.reform.cmc.submit.domain.models.interest.Interest;
import uk.gov.hmcts.reform.cmc.submit.domain.models.particulars.HousingDisrepair;
import uk.gov.hmcts.reform.cmc.submit.domain.models.particulars.PersonalInjury;
import uk.gov.hmcts.reform.cmc.submit.domain.models.payment.Payment;
import uk.gov.hmcts.reform.cmc.submit.domain.models.timeline.TimelineEvent;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ClaimInput {

    private UUID externalId;

    @Valid
    @NotEmpty
    private List<? extends Party> claimants;

    @Valid
    @NotEmpty
    private List<? extends TheirDetails> defendants;

    @Valid
    @NotNull
    private Payment payment;

    @Valid
    @NotNull
    private Amount amount;

    @Valid
    @NotNull
    private Interest interest;

    @Valid
    private PersonalInjury personalInjury;

    @Valid
    private HousingDisrepair housingDisrepair;

    @Valid
    private List<TimelineEvent> timeline;

    @Valid
    private List<Evidence> evidences;

    @NotBlank
    private String reason;

    @Valid
    private StatementOfTruth statementOfTruth;

    private String preferredCourt;

}
