package com.group53.controllers;

import com.group53.beans.*;
import com.group53.dao.EntityDAOImpl;
import com.group53.dao.EntityParameterDAOImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Controller for enter to system and check login-password
 */
@Controller
public class LoginController {
    private static final Logger logger = Logger.getLogger(LoginController.class);

    @Autowired
    private EntityDAOImpl entityDAO;

    @Autowired
    private EntityParameterDAOImpl entityParameterDAO;


    /**
     * Inner class for checking login-password
     */
    public static class LoginPassword {
        private String login;
        private String password;
        private Long userId;

        /**
         * Empty constructor
         */
        public LoginPassword() {
        }

        /**
         * Constructor
         * @param login the user login
         * @param password the user password
         * @param userId id of the entity
         */
        public LoginPassword(String login, String password, Long userId) {
            this.login = login;
            this.password = password;
            this.userId = userId;
        }

        /**
         * Return the id of the entity
         * @return id of the entity
         */
        public Long getUserId() {
            return userId;
        }

        /**
         * Setup the id of the entity
         * @param userId id of the entity
         */
        public void setUserId(Long userId) {
            this.userId = userId;
        }

        /**
         * Return the user login
         * @return the user login
         */
        public String getLogin() {
            return login;
        }

        /**
         * Setup the user login
         * @param login the user login
         */
        public void setLogin(String login) {
            this.login = login;
        }

        /**
         * Return the user password
         * @return the user password
         */
        public String getPassword() {
            return password;
        }

        /**
         * Setup the user password
         * @param password the user password
         */
        public void setPassword(String password) {
            this.password = password;
        }
    }

    /**
     * Check the user login-password and the return enter page define the type
     * @param loginPassword the user login-password
     * @return the enter page define the type
     */
    @RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
    public ModelAndView checkLogin(@ModelAttribute LoginPassword loginPassword) {

        EntityParameter loginParameter = entityParameterDAO.checkLogin(loginPassword.getLogin());

        if (loginParameter != null) {
            Entity entity = entityDAO.getEntity(loginParameter.getEntityId());

            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            EntityParameter passwordParameter = entityParameterDAO.getParameter(loginParameter.getEntityId(),entityDAO.getId("password"));

            if (passwordEncoder.matches(loginPassword.getPassword(),passwordParameter.getStringValue())) {

                logger.info("Enter new user with  " + entity.getId());
                int entityType = entity.getEntityType();
                switch (entityType) {
                    case Student.student_entity_type:   return new ModelAndView("redirect:/mark?id=" + entity.getId());

                    case Tutor.tutor_entity_type:       Entity newEntity = new Entity();
                        newEntity.setId(entity.getId());
                        List<Entity> entityList = entityDAO.getChildEntitys(entity.getId());

                        ModelAndView model = new ModelAndView("subjects", "list", entityList);

                        for (Long idStudyLoad : entityParameterDAO.getStudyLoadByTutor(entity.getId()))
                            entityList.add(entityDAO.getEntity(idStudyLoad));
                        model.addObject("list", entityList);
                        model.addObject("entity", newEntity);
                        return model;

                    case University.university_entity_type:   return new ModelAndView("redirect:/viewAll");

                    default:   return new ModelAndView("redirect:/viewAll");
                }
            }
            else
           {
                ModelAndView errorPage = new ModelAndView("errorPage");
                errorPage.addObject("errorMsg", "Wrong password");
                return errorPage;
            }
        }
        else
        {
            ModelAndView errorPage = new ModelAndView("errorPage");
            errorPage.addObject("errorMsg", "Wrong login");
            return errorPage;
        }
    }

    /**
     * Save password and the return enter page define the type
     * @param loginPassword the user login-password
     * @return enter page define the type
     */
    @RequestMapping(value = "/saveLogin", method = RequestMethod.POST)
    public ModelAndView saveLogin(@ModelAttribute LoginPassword loginPassword) {

        EntityParameter entityParameter = new EntityParameter();
        entityParameter.setParameterId(entityDAO.getId("login"));
        entityParameter.setEntityId(loginPassword.getUserId());
        entityParameter.setStringValue(loginPassword.getLogin());
        entityParameterDAO.saveParameterDB(entityParameter);
        entityParameter.setParameterId(entityDAO.getId("password"));
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(loginPassword.getPassword());
        entityParameter.setStringValue(hashedPassword);
        entityParameterDAO.saveParameterDB(entityParameter);
        EntityParameter loginParameter = entityParameterDAO.checkLogin(loginPassword.getLogin());
        Entity entity = entityDAO.getEntity(loginPassword.getUserId());
        logger.info("The param with entity id = " + entityParameter.getEntityId() + " was saved");

        int entityType = entity.getEntityType();

        switch (entityType) {
            case Student.student_entity_type:   return new ModelAndView("redirect:/mark?id=" + entity.getId());

            case Tutor.tutor_entity_type:       Entity newEntity = new Entity();
                List<Entity> entityList = entityDAO.getChildEntitys(entity.getId());
                ModelAndView model = new ModelAndView("subjects", "list", entityList);

                for (Long idStudyLoad : entityParameterDAO.getStudyLoadByTutor(entity.getId()))
                    entityList.add(entityDAO.getEntity(idStudyLoad));
                model.addObject("list", entityList);
                model.addObject("entity", newEntity);
                return model;

            case University.university_entity_type:   return new ModelAndView("redirect:/viewAll");

            default:                            return new ModelAndView("redirect:/viewAll");
        }
    }

    /**
     * Return enter page define the type
     * @param request id of the entity
     * @return enter page define the type
     */
    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public ModelAndView start(HttpServletRequest request){
        Long id = Long.parseLong(request.getParameter("id"));
        Entity entity = entityDAO.getEntity(id);
        int entityType = entity.getEntityType();

        switch (entityType) {
            case Student.student_entity_type:   return new ModelAndView("redirect:/mark?id=" + entity.getId());

            case Tutor.tutor_entity_type:       Entity newEntity = new Entity();
                List<Entity> entityList = entityDAO.getChildEntitys(entity.getId());
                ModelAndView model = new ModelAndView("subjects", "list", entityList);

                for (Long idStudyLoad : entityParameterDAO.getStudyLoadByTutor(entity.getId()))
                    entityList.add(entityDAO.getEntity(idStudyLoad));
                model.addObject("list", entityList);
                model.addObject("entity", newEntity);
                return model;

            case University.university_entity_type:   return new ModelAndView("redirect:/viewAll");

            default:                            return new ModelAndView("redirect:/viewAll");
        }
    }

    /**
     * Return the page for login change
     * @param request id of the entity
     * @return the page for login change
     */
    @RequestMapping(value = "/loginChange", method = RequestMethod.GET)
    public ModelAndView login(HttpServletRequest request){
        Long id = Long.parseLong(request.getParameter("id"));
        LoginPassword loginPassword = new LoginPassword();
        loginPassword.setUserId(id);
        EntityParameter entityParameter = entityParameterDAO.getParameter(id,entityDAO.getId("login"));
        loginPassword.setLogin(entityParameter.getStringValue());
        return new ModelAndView("login", "loginPassword", loginPassword);
    }

    /**
     * Return the page for enter the user login-password
     * @return the page for enter the user login-password
     */
    @RequestMapping("enter")
    public ModelAndView enter(){
        return new ModelAndView("enter", "loginPassword", new LoginPassword());
    }

}
