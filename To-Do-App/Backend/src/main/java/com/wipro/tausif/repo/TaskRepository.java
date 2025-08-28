package com.wipro.tausif.repo;



import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.tausif.model.Priority;
import com.wipro.tausif.model.Task;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
  List<Task> findByPriority(Priority priority);
}
