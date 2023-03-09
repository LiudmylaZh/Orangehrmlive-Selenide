import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class) //данный класс запускает выбранные тесты помеченные категории//
@Categories.IncludeCategory (Smoke.class)//те которые относятся к smoke//
@Suite.SuiteClasses({LoginTest.class, SidebarTest.class}) //нужно указывать с каких классов берем тесты//
public class RunnerTest extends BaseTest{
}
