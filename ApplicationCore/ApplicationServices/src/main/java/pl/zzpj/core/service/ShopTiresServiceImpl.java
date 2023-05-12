package pl.zzpj.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;
import pl.zzpj.core.domain.model.shopModel.ShopEquipment;
import pl.zzpj.core.domain.model.shopModel.ShopTire;
import pl.zzpj.ports.command.ShopEquipment.ShopTiresCommandPort;
import pl.zzpj.ports.command.ShopEquipment.ShopTiresCommandService;
import pl.zzpj.ports.query.ShopEquipment.ShopTiresQueryPort;
import pl.zzpj.ports.query.ShopEquipment.ShopTiresQueryService;


import java.util.List;
import java.util.UUID;

@ApplicationScope
@Service
public class ShopTiresServiceImpl implements ShopTiresCommandService, ShopTiresQueryService {

    private final ShopTiresCommandPort commandPort;

    private final ShopTiresQueryPort queryPort;

    @Autowired
    public ShopTiresServiceImpl(ShopTiresCommandPort commandPort, ShopTiresQueryPort queryPort) {
        this.commandPort = commandPort;
        this.queryPort = queryPort;
    }

    @Override
    public ShopTire addEquipment(ShopTire tire) {
        return null;
    }

    @Override
    public ShopTire updateEquipment(UUID id, ShopTire tire) {
        return null;
    }

    @Override
    public void removeEquipment(UUID id) {

    }

    @Override
    public List<ShopTire> getAllEquipment() {
        return null;
    }

    @Override
    public ShopTire getEquipmentById(UUID id) {
        return null;
    }


    //TODO



}
