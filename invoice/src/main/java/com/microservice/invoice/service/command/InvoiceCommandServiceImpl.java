package com.microservice.invoice.service.command;

import com.microservice.invoice.dto.InvoiceGetDTO;
import com.microservice.invoice.dto.InvoicePostDTO;
import com.microservice.invoice.dto.order.OrderDetailPostDTO;
import com.microservice.invoice.dto.order.OrderPostDTO;
import com.microservice.invoice.entity.Invoice;
import com.microservice.invoice.entity.InvoiceDetail;
import com.microservice.invoice.mapper.InvoiceDetailMapper;
import com.microservice.invoice.mapper.InvoiceMapper;
import com.microservice.invoice.repository.InvoiceDetailRepository;
import com.microservice.invoice.repository.InvoiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class InvoiceCommandServiceImpl implements InvoiceCommandService {
    @Autowired
    private InvoiceRepository invoiceRepository;
    @Autowired
    private InvoiceDetailRepository invoiceDetailRepository;
    private InvoiceMapper invoiceMapper;
    private InvoiceDetailMapper invoiceDetailMapper;

    private Invoice orderDtoToInvoice(OrderPostDTO orderDto){
        Invoice invoice = new Invoice();
        invoice.setNumber(123);
        invoice.setDate(orderDto.getDate());
        invoice.setSubtotal(orderDto.getSubtotal());
        invoice.setTotal(orderDto.getTotal());
        invoice.setClientId(orderDto.getIdClient());
        invoice.setCustomerAddress(orderDto.getAddress());
        invoice.setDeliveryState(orderDto.getDeliveryState().getState());
        invoice.setOrderState(orderDto.getOrderState().getState());
        invoice.setPaymentState(orderDto.getPaymentState().getState());
        invoice.setCustomerDocument(orderDto.getClientDocument());
        invoice.setCustomerName(orderDto.getClientName());
        invoice.setCustomerLastName(orderDto.getClientLastName());
        invoice.setCustomerPhone(orderDto.getClientPhone());

        List<InvoiceDetail> details = new ArrayList<>();
        for (OrderDetailPostDTO orderDetail : orderDto.getOrderDetails()) {
            InvoiceDetail detail = new InvoiceDetail();
            detail.setProductName(orderDetail.getName());
            detail.setQuantity(orderDetail.getAmount());
            detail.setPrice(orderDetail.getPrice());
            detail.setTotal(orderDetail.getPrice());
            details.add(detail);
        }
        invoice.setDetails(details);
        return invoice;
    }

    @Override
    public Invoice save(InvoicePostDTO invoiceDto) {
        List<InvoiceDetail> details = invoiceDetailMapper.toInvoiceDetails(invoiceDto.getDetails());
        Invoice invoice = invoiceMapper.toInvoice(invoiceDto);
        invoice.setDetails(null);
        invoiceRepository.save(invoice);
        for (InvoiceDetail detail: details) {
            detail.setInvoiceId(invoice.getId());
        }
        invoice.setDetails(invoiceDetailRepository.saveAll(details));
        return invoice;
    }

    @Override
    public InvoiceGetDTO createInvoice(OrderPostDTO orderDto) {
        Invoice invoice = orderDtoToInvoice(orderDto);
        List<InvoiceDetail> details = invoice.getDetails();
        invoice.setDetails(null);
        invoiceRepository.save(invoice);
        for (InvoiceDetail detail: details) {
            detail.setInvoiceId(invoice.getId());
        }
        invoice.setDetails(invoiceDetailRepository.saveAll(details));
        return invoiceMapper.toInvoiceDto(invoice);
    }
}
