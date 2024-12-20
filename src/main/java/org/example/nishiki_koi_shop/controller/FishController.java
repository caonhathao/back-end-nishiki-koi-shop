package org.example.nishiki_koi_shop.controller;

import lombok.RequiredArgsConstructor;
import org.example.nishiki_koi_shop.model.dto.FishDto;
import org.example.nishiki_koi_shop.repository.FishRepository;
import org.example.nishiki_koi_shop.service.impl.FishServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fish")
@RequiredArgsConstructor
public class FishController {
    private final FishServiceImpl fishServiceImpl;
    private final FishRepository fishRepository;

    @GetMapping("/{id}")
    public ResponseEntity<FishDto> getFishById(@PathVariable Long id) {
        FishDto fishDto = fishServiceImpl.getFishById(id);
        return ResponseEntity.ok(fishDto);
    }

    @GetMapping
    public ResponseEntity<List<FishDto>> getAllFish() {
        List<FishDto> fishList = fishServiceImpl.getAllFish();
        return ResponseEntity.ok(fishList);
    }

    @GetMapping("/filter-by-type/{id}")
    public ResponseEntity<List<FishDto>> getFishByFishType(@PathVariable Long id) {
        return new ResponseEntity<>(fishRepository.findByFishType(id), HttpStatus.OK);
    }

    @GetMapping("/filter-by-farm/{id}")
    public ResponseEntity<List<FishDto>> getFishByNyFarm(@PathVariable Long id) {
        return new ResponseEntity<>(fishRepository.findByFarmId(id), HttpStatus.OK);
    }
}
