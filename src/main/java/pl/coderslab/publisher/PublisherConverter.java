package pl.coderslab.publisher;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PublisherConverter implements Converter<String, Publisher> {
    private final PublisherRepository publisherRepository;

    public PublisherConverter(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public Publisher convert(String source) {
        return publisherRepository.findById(Long.parseLong(source)).orElse(null);
    }
}
