
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.mockito.Mockito;

class ExternalApi {
    public String getData() { return "Real Data"; }
}

class MyService {
    private final ExternalApi api;
    public MyService(ExternalApi api) { this.api = api; }
    public String fetchData() { return api.getData(); }
}

public class MyServiceTest {
    @Test
    public void testVerifyInteraction() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        MyService service = new MyService(mockApi);
        service.fetchData();
        verify(mockApi).getData();
    }
} 