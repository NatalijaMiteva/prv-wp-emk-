package mk.ukim.finki.wp.web.resources;

import mk.ukim.finki.wp.model.FavoriteItem;
import mk.ukim.finki.wp.model.User;
import mk.ukim.finki.wp.service.FavoriteItemService;
import mk.ukim.finki.wp.service.UserService;
import mk.ukim.finki.wp.web.CrudResource;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/data/rest/favorite_items")
public class FavoriteItemResource extends
        CrudResource<FavoriteItem, FavoriteItemService> {

    @Autowired
    private FavoriteItemService service;

    @Autowired
    private UserService userService;


    @Override
    public FavoriteItemService getService() {
        return service;
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public FavoriteItem create(@RequestBody FavoriteItem entity, HttpServletRequest request,
                               HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(authentication.getName());
        String tempToken = tempToken(request);
        entity.setUserToken(tempToken);
        entity.setUser(user);

        List<FavoriteItem> items = service.findByUserToken(tempToken);
        Boolean isInList = false;

        for (FavoriteItem item : items) {
            if (item.getAdvert().getId().equals(entity.getAdvert().getId()) && item.getUserToken().equals(tempToken)) {
                isInList = true;
                break;
            }
        }

        if (!isInList) {
            getService().save(entity);
            return entity;
        }
        return null;
    }

    @RequestMapping(value = "/my", method = RequestMethod.GET, produces = "application/json")
    public List<FavoriteItem> myFavoriteItems(HttpServletRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return service.findByUserUsername(authentication.getName());
    }

    @RequestMapping(value = "/check_pay", method = RequestMethod.POST, produces = "application/json")
    public void pay(HttpServletRequest request) {
        System.out.println("pay invoked");
    }

    public static String tempToken(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies) {
            if (c.getName().equals("temp_token")) {
                return c.getValue();
            }
        }
        return null;
    }


}
