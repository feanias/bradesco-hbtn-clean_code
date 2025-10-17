
import java.util.Date;
import org.springframework.web.bind.annotation.PostMapping;

public class Functions {

    public void saveIncome(Income income) {
        inRepo.save(income);
    }

    public void saveExpense(Expense expense) {
        outRepo.save(expense);
    }

    @PostMapping("/user")
    public User saveUser(User user) {
        return userService.save(user);
    }

    public void saveUser(User user) {

    }

    public User saveUserWithSideEffect(User user) {
        if(user.isAdmin) {
            user.setRole(user);
        }
        return userRepository.save(user);
    }

    public void setRole(User user) {
        user.setRole(user);
    }

    public Environment getEnvironment() {
        return environmentService.getEnvironment(getVersion());
    }

    public Release getRelease() {
        return releaseService.getRelease(getVersion());
    }

    private String getVersion() {
        return versionService.getVersion();
    }

    public static class Income {

    }

    public static class Expense {

    }

    public static class User {
        public boolean isAdmin;

        public void setRole(User user) {

        }
    }

    public static class Environment {

    }

    public static class Release {

    }


    private static IncomeRepository inRepo;
    private static ExpenseRepository outRepo;
    private static UserService userService;
    private static UserRepository userRepository;
    private static EnvironmentService environmentService;
    private static ReleaseService releaseService;
    private static VersionService versionService;

    interface IncomeRepository {
        void save(Income income);
    }

    interface ExpenseRepository {
        void save(Expense expense);
    }

    interface UserService {
        User save(User user);
    }

    interface UserRepository {
        User save(User user);
    }

    interface EnvironmentService {
        Environment getEnvironment(String version);
    }

    interface ReleaseService {
        Release getRelease(String version);
    }

    interface VersionService {
        String getVersion();
    }
}
