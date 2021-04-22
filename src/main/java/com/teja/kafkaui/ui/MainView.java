package com.teja.kafkaui.ui;

import com.teja.kafkaui.models.KafkaServer;
import com.teja.kafkaui.repo.ServerRepo;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout {

    private final ServerRepo serverRepo;
    final Grid<KafkaServer> serverGrid;

    public MainView(ServerRepo serverRepo) {
        this.serverRepo = serverRepo;
        this.serverGrid = new Grid<>(KafkaServer.class);
        Button button = new Button("click", buttonClickEvent -> Notification.show("success"));
        add(button);
        add(serverGrid);
        listServers();
    }

    private void listServers(){
        serverGrid.setItems(serverRepo.findAll());
    }
}
