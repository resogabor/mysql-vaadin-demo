package hu.rate.tanul.jpa.ui;

import com.vaadin.data.Binder;
import com.vaadin.data.ValidationException;
import com.vaadin.data.provider.DataProvider;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.event.MouseEvents;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.SingleSelect;
import com.vaadin.ui.components.grid.SingleSelectionModel;
import hu.rate.tanul.jpa.entity.User;
import hu.rate.tanul.jpa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * Created by resog on 2017. 09. 27..
 */
@SpringComponent
public class MainView extends MainUIDesign {

    @Autowired
    UserRepository userRepository;

    private ListDataProvider<User> users;
    private User user = new User();
    private SingleSelect<User> selection;

    @PostConstruct
    private void init(){
        //users = DataProvider.fromStream(userRepository.findAll().stream());
        Binder<User> binder = new Binder<>();
        binder.bind(firstName, User::getName, User::setName);
        binder.bind(email, User::getEmail, User::setEmail);

        users = DataProvider.ofCollection(userRepository.findAll());

        list.setDataProvider(users);

        list.addSelectionListener(e->{
            selection = list.asSingleSelect();

            user = selection.getValue();
            binder.readBean(user);
        });

//        list.addItemClickListener(e->{
//
//             selection = list.asSingleSelect();
//            user = e.getItem();//selection.getValue();
//            binder.readBean(user);
//        });

        update.addClickListener(e->{
            try {
                binder.writeBean(user);
                userRepository.saveAndFlush(user);
                users.refreshAll();// refreshItem(user);
            }catch (ValidationException ex){

            }
        });
        delete.addClickListener(e->{
            binder.removeBean();
            userRepository.delete(user);
            userRepository.flush();
            users.refreshAll();
        });
        cancel.addClickListener(e->{
            binder.readBean(user);
        });
        search.addValueChangeListener(e->{
            if (search.getValue().isEmpty()){

                users = DataProvider.fromStream(userRepository.findAll().stream());
            }else{
                users = DataProvider.fromStream(userRepository.findByNameStartsWithIgnoreCase(search.getValue()).stream());
            }
            users.refreshAll();
        });
    }


}