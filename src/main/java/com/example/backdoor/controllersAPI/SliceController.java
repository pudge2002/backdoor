package com.example.backdoor.controllersAPI;

import com.example.backdoor.model.Slice;
import com.example.backdoor.repos.SliceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/slices")
public class SliceController {

    @Autowired
    private SliceRepository sliceRepository;

    @GetMapping
    public List<Slice> getAllSlices() {
        return sliceRepository.findAll();
    }

    @GetMapping("/{id}")
    public Slice getSliceById(@PathVariable Long id) {
        return sliceRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Slice createSlice(@RequestBody Slice slice) {
        return sliceRepository.save(slice);
    }

    @PutMapping("/{id}")
    public Slice updateSlice(@PathVariable Long id, @RequestBody Slice sliceDetails) {
        Slice slice = sliceRepository.findById(id).orElse(null);
        if (slice != null) {
            slice.setParametrs(sliceDetails.getParametrs());
            slice.setName(sliceDetails.getName());
            slice.setValue(sliceDetails.getValue());
            return sliceRepository.save(slice);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteSlice(@PathVariable Long id) {
        sliceRepository.deleteById(id);
    }
}
