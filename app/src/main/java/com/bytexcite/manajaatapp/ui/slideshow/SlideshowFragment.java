package com.bytexcite.manajaatapp.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.bytexcite.manajaatapp.R;
import com.bytexcite.manajaatapp.databinding.FragmentSlideshowBinding;
import com.github.barteksc.pdfviewer.PDFView;

public class SlideshowFragment extends Fragment {

    private FragmentSlideshowBinding binding;
    public static final String SAMPLE_FILE = "duaBook.pdf";
    PDFView pdfView;
    Integer pageNumber = 190;
    String pdfFileName;

    private void displayFromAsset(String assetFileName) {
        pdfFileName = assetFileName;

        pdfView.fromAsset(SAMPLE_FILE)
                .defaultPage(pageNumber)
                .enableSwipe(true)
                .swipeHorizontal(false)
                .load();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        pdfView= root.findViewById(R.id.pdfView2);
        displayFromAsset(SAMPLE_FILE);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}