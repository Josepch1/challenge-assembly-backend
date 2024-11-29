package josehomenhuck.assembly.domain.enums;

import lombok.Getter;

@Getter
public enum VoteType {
    YES("Yes"),
    NO("No");

    private final String voteType;

    VoteType(String voteType) {
        this.voteType = voteType;
    }

}
