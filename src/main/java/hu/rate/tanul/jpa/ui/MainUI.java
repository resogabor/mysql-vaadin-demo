package hu.rate.tanul.jpa.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import hu.rate.tanul.jpa.entity.User;
import hu.rate.tanul.jpa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by resog on 2017. 09. 27..
 */
@Theme("apptheme")
@SpringUI(path = "/")
public class MainUI extends UI{

    @Autowired
    MainView mainView;

    @Autowired
    UserRepository userRepository;

    @Override
    protected void init(VaadinRequest request) {
//        userRepository.save(new User("Jack", "Bauer"));
//		userRepository.save(new User("Chloe", "O'Brian"));
//		userRepository.save(new User("Kim", "Bauer"));
//		userRepository.save(new User("David", "Palmer"));
//		userRepository.save(new User("Michelle", "Dessler"));
//		userRepository.flush();
        mainView.list.setItems(userRepository.findAll());
        setContent(mainView);
    }
}
