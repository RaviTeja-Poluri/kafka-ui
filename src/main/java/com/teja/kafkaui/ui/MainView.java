package com.teja.kafkaui.ui;

import com.teja.kafkaui.models.KafkaServer;
import com.teja.kafkaui.repo.ServerRepo;
import com.vaadin.flow.component.AbstractField.ComponentValueChangeEvent;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.HasValue;
import com.vaadin.flow.component.HasValue.ValueChangeListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.BackEndDataProvider;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.provider.DataProviderListener;
import com.vaadin.flow.data.provider.Query;
import com.vaadin.flow.data.provider.QuerySortOrder;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.shared.Registration;
import java.util.List;
import java.util.stream.Stream;
import org.springframework.util.StringUtils;

@Route
public class MainView extends VerticalLayout {

    private final ServerRepo serverRepo;
    final Grid<KafkaServer> serverGrid;

    public MainView(ServerRepo serverRepo) {
        this.serverRepo = serverRepo;
        this.serverGrid = new Grid<>(KafkaServer.class);
        add(createLayout());
        add(serverGrid);
        listServers();
    }

    private HorizontalLayout createLayout(){
        TextField textField = new TextField("kafka servers", "localhost:9092");
        final Button button = new Button("add server", buttonClickEvent -> {
                String value = textField.getValue();
                if (!StringUtils.hasLength(value)){
                    value = textField.getPlaceholder();
                }
                KafkaServer kafkaServer = new KafkaServer();
                kafkaServer.setKafkaServers(value);
                serverRepo.save(kafkaServer);
                listServers();
            });
        return new HorizontalLayout(textField,button);
    }

    private void listServers(){
        serverGrid.setItems(serverRepo.findAll());
    }
}
