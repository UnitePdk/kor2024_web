package day57;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

public class MVC {

}
// ----- MVC1
class ViewController{ }
class Mvc1Dao{}

// -----MVC2
class Mvc2View{}
class Mvc2Controller{}
class Mvc2Dao{}

// -----MVC2 3티어
@RestController
class Mvc2Tier3Controller{}
@Service
class Mvc2Tier3Service{}
@Component
class Mvc2Tier3Dao{}