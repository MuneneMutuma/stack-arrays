package kirwa.stack.demo.StackControllers;

import kirwa.stack.demo.Services.StackService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
@Slf4j
public class StackControllers {
    @Autowired
    StackService stackService;


    @GetMapping(path="/api/{stringNumber}")
    public String addItemToStack(@PathVariable String stringNumber) throws Exception {
        int number=Integer.parseInt(stringNumber);
        stackService.push(number);
        return number+"added to the stack array";
    }

    @GetMapping("/api/top")
    public int getTopItem() throws Exception {
        return  stackService.peek();
    }
    @GetMapping(path="/api/length")
    public int getStackLength() throws Exception {
        return  stackService.getLength();
    }

    @GetMapping(path="/api/pop")
    public int[] popItem() throws Exception {
        return stackService.pop();
    }

}
