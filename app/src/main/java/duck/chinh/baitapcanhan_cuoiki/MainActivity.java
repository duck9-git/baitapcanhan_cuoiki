package duck.chinh.baitapcanhan_cuoiki;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import duck.chinh.baitapcanhan_cuoiki.fragment.AccountFragment;
import duck.chinh.baitapcanhan_cuoiki.fragment.HistoryFragment;
import duck.chinh.baitapcanhan_cuoiki.fragment.BookmarkFragment;
import duck.chinh.baitapcanhan_cuoiki.fragment.WalletFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_nav_menu);

        // Thiết lập trang chủ được chọn mặc định
        bottomNavigationView.setSelectedItemId(R.id.Home);

        // Thiết lập listener cho sự kiện chọn item trong bottom navigation
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null; // Khởi tạo fragment được chọn

                // Xử lý item được chọn
                if (item.getItemId() == R.id.Home) {
                    Intent intent = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                    return true;
                } else if (item.getItemId() == R.id.activity) {
                    selectedFragment = new HistoryFragment();
                } else if (item.getItemId() == R.id.mess) {
                    selectedFragment = new BookmarkFragment();
                } else if (item.getItemId() == R.id.payment) {
                    selectedFragment = new WalletFragment();
                } else if (item.getItemId() == R.id.profile) {
                    selectedFragment = new AccountFragment();
                }

                // Nạp Fragment
                return loadFragment(selectedFragment);
            }
        });

        // Hiển thị mặc định Fragment đầu tiên
        loadFragment(new HistoryFragment());
    }

    /**
     * Phương thức dùng để thay thế Fragment hiện tại bằng Fragment được chọn.
     *
     * @param fragment Fragment cần hiển thị
     * @return true nếu Fragment được nạp thành công, false nếu không
     */
    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment) // fragment_container là ID của ViewGroup trong layout
                    .commit();
            return true;
        }
        return false;
    }
}
