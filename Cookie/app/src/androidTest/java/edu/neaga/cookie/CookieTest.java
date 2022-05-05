package edu.neaga.cookie;

import static org.junit.Assert.assertEquals;

import android.app.Service;
import android.content.Context;
import android.util.Log;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import edu.neaga.cookie.http.RetrofitCookie;
import edu.neaga.cookie.http.ServiceCookie;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class CookieTest {
    @Test
    public void testCookie() throws IOException {
        ServiceCookie service = RetrofitCookie.get();
        for (int i = 0; i < 10; i++) {
            Call<String> call = service.cookieEcho();
            Response<String> response = call.execute();
            String resultat = response.body();
            Log.i("RETROFIT", resultat);
        }
    }
}