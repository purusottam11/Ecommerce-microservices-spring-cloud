package com.example.purusottam.blkdataimport.importdta;


import com.example.purusottam.blkdataimport.model.Demo;
import com.example.purusottam.blkdataimport.model.DemoDto;
import org.springframework.batch.item.ItemProcessor;

public class DemoProcesser implements ItemProcessor<Demo, DemoDto> {
    @Override
    public DemoDto process(Demo demo) throws Exception {
        System.out.println("Transforming Demo(s) to DemoDto(s)..");
        final DemoDto demoDto = new DemoDto(demo.getUniq_id(), demo.getCrawl_timestamp(),
                demo.getProduct_url(), demo.getProduct_name(), demo.getProduct_category_tree(), demo.getPid(), demo.getRetail_price()
                , demo.getDiscounted_price(), demo.getImage(), demo.getIs_FK_Advantage_product(), demo.getDescription(), demo.getProduct_rating(), demo.getOverall_rating(), demo.getBrand(), demo.getProduct_specifications());

        return demoDto;
    }
}
