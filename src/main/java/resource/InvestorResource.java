package resource;

import db.Investor;
import db.InvestorDAO;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Moe on 2/10/18.
 */
@Path("/investor")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class InvestorResource {

    private InvestorDAO investorDAO;

    public InvestorResource(InvestorDAO investorDAO) {
        this.investorDAO = investorDAO;
    }

    @GET
    @UnitOfWork
    public Response getInvestors() {
        return Response.ok(investorDAO.getInvestors()).build();
    }

    @GET
    @UnitOfWork
    @Path("/{name}")
    public Response getInvestor(@PathParam("name") String name) {
        return Response.ok(investorDAO.getInvestor(name)).build();
    }

    @POST
    @Path("/update")
    @UnitOfWork
    public Response updateInvestor(Investor investor) {
        investorDAO.updateInvestor(investor);
        return Response.ok().build();
    }


    @POST
    @Path("/add")
    @UnitOfWork
    public Response addInvestor(Investor investor) {
        investorDAO.addInvestor(investor);
        return Response.ok().build(); // http responses
    }

    @DELETE
    @Path("/delete/{id}")
    @UnitOfWork
    public Response removeInvestor(@PathParam("id") int id) {
        investorDAO.removeInvestor(id);
        return Response.ok().build();
    }
}