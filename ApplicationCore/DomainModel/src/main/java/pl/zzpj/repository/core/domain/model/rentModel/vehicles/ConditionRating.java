package pl.zzpj.repository.core.domain.model.rentModel.vehicles;

public enum ConditionRating {
    SUNNY("SUNNY"), ALLWEATHER("ALLWEATHER"), TOUGH("TOUGH"), DRY("DRY");


    public final String name;


    ConditionRating(String name) {
        this.name = name;
    }

    public static ConditionRating getByName(String name) {
        if (name.contains("SUNNY")) {
            return ConditionRating.SUNNY;
        } else if (name.contains("DRY")) {
            return ConditionRating.DRY;
        } else if (name.contains("TOUGH")) {
            return ConditionRating.TOUGH;
        } else {
            return ConditionRating.ALLWEATHER;
        }
    }
}
