package pl.zzpj.repository.core.domain.model.rentModel.vehicles;

public enum ConditionRating {
    SUNNY ("SUNNY"),
    OVERCAST ("OVERCAST"),
    RAINY ("RAINY"),
    STORMY ("STORMY"),
    SNOWY ("SNOWY");

    public final String name;


    ConditionRating(String name) {
        this.name = name;
    }
}
