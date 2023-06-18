package pl.zzpj.repository.core.domain.model.rentModel.vehicles;

public enum ConditionRating {
    SUNNY ("SUNNY"),
    ALLWEATHER ("ALLWEATHER"),
    TOUGH ("TOUGH"),
    DRY ("DRY");



    public final String name;


    ConditionRating(String name) {
        this.name = name;
    }
}
