package com.clientflow.config;

import com.clientflow.customer.*;
import com.clientflow.lead.*;
import com.clientflow.task.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDate;

@Configuration
public class DemoData {
    @Bean
    CommandLineRunner seedData(LeadRepository leads, CustomerRepository customers, TaskRepository tasks) {
        return args -> {
            if (leads.count() == 0) {
                leads.save(new Lead("Ananya Rao", "Northstar Labs", "ananya@northstar.example", "+91 98765 01001", "Website", "Maya", "Negotiation", 185000.0, LocalDate.now().minusDays(1)));
                leads.save(new Lead("Rahul Mehta", "BrightPath", "rahul@brightpath.example", "+91 98765 01002", "Referral", "Arjun", "Contacted", 92000.0, LocalDate.now().minusDays(2)));
                leads.save(new Lead("Sana Khan", "CloudPeak", "sana@cloudpeak.example", "+91 98765 01003", "LinkedIn", "Maya", "New", 75000.0, LocalDate.now().minusDays(3)));
                leads.save(new Lead("Vikram Das", "FinEdge", "vikram@finedge.example", "+91 98765 01004", "Campaign", "Riya", "Won", 240000.0, LocalDate.now().minusDays(4)));
                leads.save(new Lead("Priya Nair", "Evergreen Co.", "priya@evergreen.example", "+91 98765 01005", "Website", "Arjun", "Lost", 50000.0, LocalDate.now().minusDays(6)));
                leads.save(new Lead("Karthik Reddy", "NovaWorks", "karthik@novaworks.example", "+91 98765 01006", "Referral", "Riya", "New", 125000.0, LocalDate.now()));
            }
            if (customers.count() == 0) {
                customers.save(new Customer("Aarav Shah", "Orbit Systems", "aarav@orbit.example", "+91 90000 01001", "Technology", "Active"));
                customers.save(new Customer("Diya Iyer", "Greenline Retail", "diya@greenline.example", "+91 90000 01002", "Retail", "Active"));
                customers.save(new Customer("Kabir Reddy", "FinEdge", "kabir@finedge.example", "+91 90000 01003", "Finance", "Active"));
                customers.save(new Customer("Meera Joshi", "CloudPeak", "meera@cloudpeak.example", "+91 90000 01004", "Technology", "Active"));
            }
            if (tasks.count() == 0) {
                tasks.save(new FollowUpTask("Send updated proposal", "Northstar Labs", "Maya", LocalDate.now().plusDays(1), "High", "Pending"));
                tasks.save(new FollowUpTask("Schedule product demo", "BrightPath", "Arjun", LocalDate.now(), "Medium", "Pending"));
                tasks.save(new FollowUpTask("Quarterly check-in", "Orbit Systems", "Riya", LocalDate.now().plusDays(3), "Low", "Pending"));
            }
        };
    }
}
