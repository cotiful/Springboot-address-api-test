package site.metacoding.jusotest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class JusoController {

    @GetMapping("/")
    public String jusoTest() {

        return "home";
    }

    // roadFullAddr로 나라에서 때린건지, 내가 때린건지 구별해줘야 함.
    // 필요한 값을 선언해서 넣어줌.
    @RequestMapping(value = "/juso/popup", method = { RequestMethod.GET, RequestMethod.POST })
    public String jusoPopup(Model model, String roadFullAddr) {

        // if (roadFullAddr == null) {
        // System.out.println("내가 버튼을 눌려서 호출 한건데");
        // } else {
        // System.out.println(roadFullAddr);
        // System.out.println("도로명 주소 국가 서버에 호출 한 건데");
        // }

        String jusoUrl = "https://www.juso.go.kr/addrlink/addrLinkUrl.do";
        String confmKey = "devU01TX0FVVEgyMDIyMDUyMzEwNDk0ODExMjYwMDI=";
        String returnUrl = "http://localhost:8080/juso/popup";
        String resultType = "4";

        if (roadFullAddr == null) {
            roadFullAddr = "N";
        }

        model.addAttribute("roadFullAddr", roadFullAddr);
        model.addAttribute("jusoUrl", jusoUrl);
        model.addAttribute("confmKey", confmKey);
        model.addAttribute("returnUrl", returnUrl);
        model.addAttribute("resultType", resultType);

        return "jusoPopup";

    }

    @PostMapping("/juso/callback")
    public void jusoCallback(String roadFullAddr) {
        System.out.println(roadFullAddr);
    }
}
