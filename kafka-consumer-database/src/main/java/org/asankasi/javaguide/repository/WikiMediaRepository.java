package org.asankasi.javaguide.repository;

import org.asankasi.javaguide.entity.WikiMedia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikiMediaRepository extends JpaRepository<WikiMedia, Long> {
}
