package knagent.com.reservations;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private LinearLayoutManager lLayout;

    private ArrayList<ItemObject> listItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Reservations");

        this.listItems = new ArrayList<ItemObject>();
        Toolbar topToolBar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(topToolBar);

        lLayout = new LinearLayoutManager(MainActivity.this);

        RecyclerView rView = (RecyclerView)findViewById(R.id.recycler_view);
        rView.setLayoutManager(lLayout);

        RecyclerViewAdapter rcAdapter = new RecyclerViewAdapter(MainActivity.this, this.listItems);
        rView.setAdapter(rcAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        if(id == R.id.action_new){

            AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
            View mView = getLayoutInflater().inflate(R.layout.dialog_input, null);
            final EditText mName = (EditText) mView.findViewById(R.id.etName);
            final EditText mPhone = (EditText) mView.findViewById(R.id.etPhone);
            final ImageView cameraButton = (ImageView) mView.findViewById(R.id.cameraButton);
            Button mEnter = (Button) mView.findViewById(R.id.btnEnter);


            mBuilder.setView(mView);
            final AlertDialog dialog = mBuilder.create();

            cameraButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


/*
                    checkCameraHardware(MainActivity.this);
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent,0);



                    for(int i = 0; i < Init.PERMISSIONS.length; i++){
                        String[] permission = {Init.PERMISSIONS[i]};
                        if(MainActivity.this.checkPermission(permission)){
                            if(i == Init.PERMISSIONS.length - 1){
                                Log.d(TAG, "onClick: opening the 'image selection dialog box'.");
                                ChangePhotoDialog dialog = new ChangePhotoDialog();
                                dialog.show(getFragmentManager(), getString(R.string.change_photo_dialog));
                                dialog.setTargetFragment(AddContactFragment.this, 0);
                            }
                        }else{
                            MainActivity.this.verifyPermissions(permission);
                        }
                    }


                    Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(cameraIntent, Init.CAMERA_REQUEST_CODE);


*/


/*

                    if (MainActivity.this.checkPermission(2)) {

                    }

                    Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(cameraIntent, Init.CAMERA_REQUEST_CODE);


*/

                    Toast.makeText(MainActivity.this,
                            "Camera Button Pressed",
                            Toast.LENGTH_SHORT).show();



                }
            });



            mEnter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(!mName.getText().toString().isEmpty() && !mPhone.getText().toString().isEmpty()){

                        lLayout = new LinearLayoutManager(MainActivity.this);

                        listItems.add(new ItemObject(mName.getText().toString(), mPhone.getText().toString(), R.drawable.placeholder));
                        RecyclerView rView = (RecyclerView)findViewById(R.id.recycler_view);
                        rView.setLayoutManager(lLayout);

                        RecyclerViewAdapter rcAdapter = new RecyclerViewAdapter(MainActivity.this, listItems);
                        rView.setAdapter(rcAdapter);

                        Toast.makeText(MainActivity.this,
                                "Add to View",
                                Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }else{
                        Toast.makeText(MainActivity.this,
                                "Error",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });

            dialog.show();


        }
        return super.onOptionsItemSelected(item);
    }

    private boolean checkCameraHardware(Context context) {
        if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)){
            // this device has a camera
            Log.d(TAG, "Camera Present");
            return true;
        } else {
            // no camera on this device
            Log.d(TAG, "No Camera");
            return false;
        }
    }



    /*
    private List<ItemObject> getAllItemList(){
        List<ItemObject> allItems = new ArrayList<ItemObject>();

        allItems.add(new ItemObject("Peter James", "973 723 9028", R.drawable.placeholder));
        allItems.add(new ItemObject("Henry Jacobs", "973 723 9028", R.drawable.placeholder));
        allItems.add(new ItemObject("Bola Olumide", "973 723 9028", R.drawable.placeholder));
        allItems.add(new ItemObject("Chidi Johnson", "973 723 9028", R.drawable.placeholder));
        allItems.add(new ItemObject("DeGordio Puritio", "973 723 9028", R.drawable.placeholder));
        allItems.add(new ItemObject("Gary Cook", "973 723 9028", R.drawable.placeholder));
        allItems.add(new ItemObject("Edith Helen", "973 723 9028", R.drawable.placeholder));
        allItems.add(new ItemObject("Kingston Dude", "973 723 9028", R.drawable.placeholder));
        allItems.add(new ItemObject("Edwin Bent", "973 723 9028", R.drawable.placeholder));
        allItems.add(new ItemObject("Grace Praise", "973 723 9028", R.drawable.placeholder));
        return allItems;
    }
    */
}
