import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import vo.Person;

/**
 * ToDo
 *
 * @author Lyle
 * @date 2021/1/23
 */
public class JacksonTest {

    public static void main(String[] args) {
        try {
            test1();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
    public static void test1() throws JsonProcessingException {
        Person p=new Person();
        p.setName("张三");
        p.setAge(18);
        p.setGender("男");
        //创建Jackson对象
        ObjectMapper mapper=new ObjectMapper();
        /**
         * writeValue()：
         * writeValueAsString():对象转json字符串
         */
        String valueAsString = mapper.writeValueAsString(p);
        System.out.println(valueAsString);
    }
}
