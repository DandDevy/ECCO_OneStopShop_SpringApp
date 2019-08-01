/*
 * written by Daniel Ashcroft
 */

package ecco.onestopshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GetProfilPageController {

    private boolean canEnter;

    @RequestMapping("/profil")
    public String profil(){
        if(canEnter)
            return "profil";
        else
            return "login";
    }

    public boolean isCanEnter() {
        return canEnter;
    }

    public void setCanEnter(boolean canEnter) {
        this.canEnter = canEnter;
    }
}
