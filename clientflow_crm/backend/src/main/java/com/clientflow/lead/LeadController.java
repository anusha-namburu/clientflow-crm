package com.clientflow.lead;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/leads")
public class LeadController {
    private final LeadRepository repository;
    public LeadController(LeadRepository repository) { this.repository = repository; }

    @GetMapping
    public List<Lead> all() { return repository.findAllByOrderByCreatedAtDesc(); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Lead create(@Valid @RequestBody Lead lead) {
        lead.setId(null);
        if (lead.getStatus() == null || lead.getStatus().isBlank()) lead.setStatus("New");
        if (lead.getDealValue() == null) lead.setDealValue(0.0);
        return repository.save(lead);
    }

    @PatchMapping("/{id}/status")
    public Lead updateStatus(@PathVariable Long id, @RequestBody Map<String, String> body) {
        Lead lead = repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Lead not found"));
        String status = body.get("status");
        if (status == null || !List.of("New", "Contacted", "Negotiation", "Won", "Lost").contains(status)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Unsupported lead status");
        }
        lead.setStatus(status);
        return repository.save(lead);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        if (!repository.existsById(id)) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Lead not found");
        repository.deleteById(id);
    }
}
